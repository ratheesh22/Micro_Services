package com.cognizant.config_client.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Limits {
	
	private int minimum;
	private int maximum;
	private String profileName;
	

}
