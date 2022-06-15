package PeticionHttpExchangeController;

import static service.PeticionHttpExchangeService.peticionHttpGet;

public class PeticionHttpExchangeController {
    public PeticionHttpExchangeController() {
    }

    public String getExchange(String url) {
        String respuesta = "";

        try {
            respuesta = peticionHttpGet(url);
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }

        return respuesta;
    }
}
