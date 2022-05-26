package it.crypto.dashboard.entity.dto;

import it.crypto.dashboard.entity.model.BitCoin;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BitCoinResponseDto implements Serializable {


    private static final long serialVersionUID = 1319601526104089332L;

    private BitCoin data;
}
