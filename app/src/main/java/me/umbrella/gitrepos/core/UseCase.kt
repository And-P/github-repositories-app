package me.umbrella.gitrepos.core

import kotlinx.coroutines.flow.Flow

     // parametros de entrada(user) e saída
abstract class UseCase<Param, Source> {

    abstract suspend fun execute(param: Param): Flow<Source>

    open suspend operator fun invoke(param: Param) = execute(param)

    // Não recebe parametro, só recebe a saída
    abstract class NoParam<Source> : UseCase<None, Flow<Source>>() {
        abstract suspend fun execute(): Flow<Source>

        final override suspend fun execute(param: None) =
            throw UnsupportedOperationException()

        suspend operator fun invoke(): Flow<Source> = execute()
    }

    // Não recebe saída, só recebe a entrada
    abstract class NoSource<Params> : UseCase<Params, Unit>() {
        override suspend operator fun invoke(param: Params) = execute(param)
    }

    //
    object None
}