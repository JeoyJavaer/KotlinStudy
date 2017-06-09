package lech.kotlinstudy.domain

/**
 * Created by Android_61 on 2017/6/6.
 * Description
 * Others
 */
public interface Command<T> {
    fun execute(): T
}