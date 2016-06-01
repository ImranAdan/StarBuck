package org.adani.starbuck.domain.product;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "Product")
public class Product {

    private long productId; //@AutoGenerated Field

    private String name;
    private BigDecimal price;
    private int quantity;
    private String imageUrl;

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @XmlElement(name = "Price")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    @XmlElement(name = "Quantity")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @XmlElement(name = "ImageURL")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String toString(){
        return  ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
