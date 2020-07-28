package enmus;

/**
 * @author fan.li
 * @date 2020-07-17
 * @description
 */
public enum BizType {
    TYPE1(1, "类型1"),
    TYPE2(2, "类型2"),
    TYPE3(3, "类型3");
    int value;
    String desc;

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    BizType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}

