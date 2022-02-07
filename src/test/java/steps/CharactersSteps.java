package steps;

import api.ApiHeaders;
import api.ApiRequest;
import characters.CharactersConstrutor;
import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import utils.PropertiesUtils;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class CharactersSteps extends ApiRequest {
    PropertiesUtils prop = new PropertiesUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();

    @Dado("que Api GameOfThrones  não solicita token")
    public void que_api_game_of_thrones_não_solicita_token() {

        System.out.println("Api não requer token");
    }

    @Quando("envio um request de cadastro de personagem com dados validos")
    public void envio_um_request_de_cadastro_de_personagem_com_dados_validos() throws IOException {
        super.uri = prop.getProp("uri_gameOfThornes");
        super.headers = apiHeaders.gameOfThrones();
        super.body = new CharactersConstrutor("Daenerys",
                faker.name().lastName(),faker.name().fullName(),
                "Lord",
                "House Lanniste",
                "lord" + ".jpg",
                faker.internet().image()).getJson();
        super.POST();
    }


    @Entao("o personagem deve ser criado com sucesso")
    public void o_personagem_deve_ser_criado_com_sucesso() {
        assertEquals(200, response.statusCode());
    }

    @Entao("o status code do requeste deve ser {int}")
    public void o_status_code_do_requeste_deve_ser(Integer statusEsperado) {
     Assertions.assertEquals(statusEsperado, response.statusCode());

    }

    @Dado("possua um personagem Cadastrado no api")
    public void possua_um_personagem_cadastrado_no_api() throws IOException {
        envio_um_request_de_cadastro_de_personagem_com_dados_validos();
    }
    @Quando("consulta dados desse personagem")
    public void consulta_dados_desse_personagem() {
        String id = "2";
        super.uri = prop.getProp("uri_gameOfThornes") + "/" + id;
        super.headers = apiHeaders.gameOfThrones();
        super.body = new JSONObject();
        super.GET();

    }
    @Entao("os dados dos personagens serem retornados")
    public void os_dados_dos_personagens_serem_retornados() {
        assertEquals("Jon", response.jsonPath().getString("firstName"));

    }

}
