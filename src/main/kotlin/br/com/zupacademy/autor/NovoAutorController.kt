package br.com.zupacademy.autor

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated // sem essa anotação, o @Valid não funciona. Não é possível nem fazer o build da aplicação
@Controller("/autores") // equivalente ao @RestController e @RequestMapping do Spring
class NovoAutorController {

    @Post // equivalente ao @PostMapping do Spring
    fun cadastra(@Valid @Body request: NovoAutorRequest) {
        // o @Body é equivalente ao @RequestBody do Spring, porém aqui no Micronaut não é obrigatório.
        println(request)
    }
}