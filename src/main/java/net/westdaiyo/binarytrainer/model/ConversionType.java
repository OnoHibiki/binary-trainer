package net.westdaiyo.binarytrainer.model;
// 変換問題の種類フラグ
public enum ConversionType {
    
    DECIMAL_TO_BINARY("10進数から2進数への変換"),
    BINARY_TO_DECIMAL("2進数から10進数への変換"),
    DECIMAL_TO_HEX("10進数から16進数への変換"),    
    HEX_TO_DECIMAL("16進数から10進数への変換"),
    BINARY_TO_HEX("2進数から16進数への変換"),
    HEX_TO_BINARY("16進数から2進数への変換");


    //String部分を表示させたい
    private final String displayName;
    ConversionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
