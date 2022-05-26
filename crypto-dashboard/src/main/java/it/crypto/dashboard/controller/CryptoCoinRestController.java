package it.crypto.dashboard.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.crypto.dashboard.service.BitcoinService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "CryptoCoinRestController", description = "API dedicata alla conversione di Crypto monete in valuta Flat")
@RestController
@RequestMapping("/api/crypto")
public class CryptoCoinRestController {

    @Autowired
    private BitcoinService bitcoinService;


    @SneakyThrows
    @Operation(summary = "Sezione CryptoCoin: operation che permette di recuperare il valore di una moneta crypto in una qualsiasi moneta Flat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "entità recuperate correttamente dal sistema.", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Errore inatteso.", content = @Content) })
    @GetMapping("/get/price/{cryptoCoin}/{flatCoin}")
    public ResponseEntity<?> getPriceBitcoin(
            @Parameter(description = "Crypto per la quale si desidera verificare il tasso di cambio") @PathVariable("cryptoCoin") String cryptoCoin,
            @Parameter(description = "Valuta flat relativa al prezzo di mercato corrente") @PathVariable("flatCoin") String flatCoin) {

        return new ResponseEntity<>(bitcoinService.getPriceData(cryptoCoin,flatCoin), HttpStatus.OK);
    }
}
