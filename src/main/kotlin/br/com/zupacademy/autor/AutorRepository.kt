package br.com.zupacademy.autor

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository // diferentemente do Spring, essa anotação é obrigatória
interface AutorRepository : JpaRepository<Autor, Long> {
}