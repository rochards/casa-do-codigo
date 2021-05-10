package br.com.zupacademy.autor

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

// lembre-se que uma data class já tem os métodos/funções equals e hashcode, toString e copy
@Introspected
data class NovoAutorRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email val email: String,
    @field:NotBlank @field:Size(max = 400) val descricao: String
) {
    fun toModel() = Autor(nome, email, descricao)
}

/*
* @Introspected -> essa anotação é necessária para que em tempo de compilação o Micronaut consiga construir a
* estrutura necessária para acessar os atributos dessa classe e realizar as validações. Caso não queira fazer
* validação, não precisa dessa anotação
*
* @field:anotação -> esse @field é necessidade do bean validation, pois assim indica que tais anotações devem ser
* inseridas nos atributos da classe e não é simplesmente uma anotação de dica no construtor. Reforçando: sem isso as
* anotações não vão para os atributos da classe.
* */
