package com.example.campingwithcompsoe.common.base

interface BaseUseCaseWithParams<in Params, out Type> {
    suspend operator fun invoke(request: Params): Type
}

interface BaseUseCase<out Type> {
    suspend operator fun invoke(): Type
}
