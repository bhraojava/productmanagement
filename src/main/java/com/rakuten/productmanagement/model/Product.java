package com.rakuten.productmanagement.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.annotations.NotThreadSafe;
import com.rakuten.productmanagement.utils.Status;
import com.rakuten.productmanagement.utils.UtilClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Product {
 	
	@Id
	@NotNull
	@Pattern(regexp = UtilClass.UUID_PATTERN, message = "UUID_PATTERN Formatet Expected")
	private String orderId;         
	private Long timestamp;
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private int status;
	@NotNull
	@DecimalMin(value = "0.1", inclusive = true, message = "min value 0.1 or higher")
	@DecimalMax(value = "9999.99", inclusive = true, message = "max value 9999.99 or lower")
	private Double orderTotal;
	@NotNull
	@DecimalMin(value = "0.1", inclusive = true, message = "min value 0.1 or higher")
	@DecimalMax(value = "9999.99", inclusive = true, message = "max value 9999.99 or lower")
	private Double shippingCost;
	@NotNull
	@Pattern(regexp = UtilClass.UUID_PATTERN, message = "UUID_PATTERN Formatet Expected")
	private String customerId;
	@NotNull
	@Pattern(regexp = UtilClass.UUID_PATTERN, message = "UUID_PATTERN Formatet Expected")
	private String itemId;              
	@NotNull
	@Size(min = 1, max = 999)
	private Integer quantity;
	@NotNull
	@NotEmpty
	private String note; 

	
	
}
