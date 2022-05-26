package it.crypto.dashboard.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.crypto.dashboard.entity.dto.BitCoinResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.javalite.http.Get;
import org.javalite.http.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class BitcoinService {

    @Value("${crypto.coinbase.spotPrice.url}")
    private String urlSpotPrice;

    @Autowired
    private final ObjectMapper objectMapper;

    public BitcoinService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Collection<BitCoinResponseDto> getPriceData(String cryptoCoin,String flatCoin) throws JsonProcessingException {

        log.debug("Valori in INPUT : {} - {}",cryptoCoin,flatCoin);

        Get get = Http.get(String.format(urlSpotPrice,cryptoCoin,flatCoin));

        String text = get.text();
        Collection<BitCoinResponseDto> readValues ;

        readValues = objectMapper.readValue(
                text, new TypeReference<>() {
                });
        return readValues;
    }
}
