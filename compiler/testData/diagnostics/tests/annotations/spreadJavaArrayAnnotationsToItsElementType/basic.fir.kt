// !DIAGNOSTICS: -UNUSED_PARAMETER

// FILE: Base.java
public class Base {
    public String [] foo() { return new String[] {}; }
}

// FILE: Anno.java
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
public @interface Anno {}

// FILE: Derived.java
import org.jetbrains.annotations.NotNull;

public class Derived extends Base {
    @Override
    public String @NotNull @Anno [] foo() { return new String[] {}; }
}

// FILE: main.kt
fun take(x: String) {}

fun main(x: Derived) {
    var y: String? = null
    if (y == null) {
        y = x.foo()[0]
    }
    take(y)
}