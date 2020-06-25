package pl.slyberry.common

import android.os.Parcel
import android.os.Parcelable
import android.text.Spannable
import android.text.TextUtils
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.text.HtmlCompat
import kotlinx.android.parcel.Parcelize

sealed class Label : Parcelable {

  companion object {
    fun create(string: String): Label = StringLabel(string)

    fun create(@StringRes resId: Int): Label = StringResLabel(resId)

    fun create(spannable: Spannable): Label = SpannableLabel(spannable)

    fun create(@StringRes resId: Int, vararg values: String): Label = PluralResLabel(resId, values.toList())

    fun createHtml(@StringRes resId: Int, vararg values: String): Label = HtmlPluralResLabel(resId, values.toList())
  }
}

@Parcelize
private data class StringLabel(val value: String) : Label()

@Parcelize
private data class StringResLabel(@StringRes val resId: Int): Label()

private data class SpannableLabel(val value: Spannable): Label() {
  constructor(parcel: Parcel) : this(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) as Spannable) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    TextUtils.writeToParcel(value, parcel, flags)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<SpannableLabel> {
    override fun createFromParcel(parcel: Parcel): SpannableLabel {
      return SpannableLabel(parcel)
    }

    override fun newArray(size: Int): Array<SpannableLabel?> {
      return arrayOfNulls(size)
    }
  }
}

@Parcelize
private data class PluralResLabel(@StringRes val resId: Int, val values: List<String>) : Label()

@Parcelize
private data class HtmlPluralResLabel(@StringRes val resId: Int, val values: List<String>) : Label()

fun TextView.setLabel(label: Label) {
  when (label) {
    is StringLabel -> setText(label.value)
    is StringResLabel -> setText(label.resId)
    is SpannableLabel -> setText(label.value)
    is PluralResLabel -> setText(context.getString(label.resId, label.values))
    is HtmlPluralResLabel -> setText(HtmlCompat.fromHtml(context.getString(label.resId, *label.values.toTypedArray()), HtmlCompat.FROM_HTML_MODE_LEGACY))
  }.exhaustive
}
