package dbteam4.booksale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PostSearchCond {
    private Long underPrice;
    private Long discountRate;
    private Boolean onSale;
    private Boolean reserved;
    private Boolean sold;
    private String shippingMethod;

    public PostSearchCond() {}
}
