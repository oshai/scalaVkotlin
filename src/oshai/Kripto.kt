package oshai

import org.junit.Assert.assertEquals
import org.junit.Test

inline fun <T> T?.getOrElse(other: T) : T =
    if (this == null) other else this

inline fun <T> T?.toList() : List<T> =
        if (this == null) emptyList() else listOf(this)

inline fun <T> T?.isEmpty() : Boolean = this == null

inline fun <T, R> T?.map(transform: (T) -> R) : R? =
        if (this == null) null else transform(this)

inline fun <T, R> T?.flatMap(transform: (T) -> R?) : R? =
        if (this == null) null else transform(this)

inline fun <T> T?.filter(predicate: (T) -> Boolean) : T? =
        if (this != null && predicate(this)) this else null

class Tests {

    val nullableNullValue: String? = null
    val nullableNotNull: String? = "hi"

    @Test fun `test getOrElse`() {
        assertEquals("ho", nullableNullValue.getOrElse("ho"))
        assertEquals("hi", nullableNotNull.getOrElse("ho"))
    }
    @Test fun `test isEmpty`() {
        assertEquals(true, nullableNullValue.isEmpty())
        assertEquals(false, nullableNotNull.isEmpty())
    }
    @Test fun `test toList`() {
        assertEquals(emptyList<String>(), nullableNullValue.toList())
        assertEquals(listOf("hi"), nullableNotNull.toList())
    }
    @Test fun `test map`() {
        assertEquals(1, nullableNotNull.map{1})
        assertEquals(null, nullableNullValue.map{1})
    }
    @Test fun `test flat map`() {
        assertEquals(1, nullableNotNull.flatMap{1})
        assertEquals(null, nullableNotNull.flatMap{null})
        assertEquals(null, nullableNullValue.flatMap{1})
    }
    @Test fun `test filter`() {
        assertEquals("hi", nullableNotNull.filter{ s -> true})
        assertEquals(null, nullableNotNull.filter{ s -> false})
        assertEquals(null, nullableNullValue.map{1})
    }
}