package com.teamsparta.todolist.infra.aop


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class StopWatch()