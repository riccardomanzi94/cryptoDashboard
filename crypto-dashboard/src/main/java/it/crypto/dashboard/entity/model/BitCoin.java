package it.crypto.dashboard.entity.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BitCoin implements Serializable {

    private static final long serialVersionUID = 5309120214674986004L;

    private String base; //es: ETH
    private String currency; //es: USD
    private String amount; //es: 1809
}
