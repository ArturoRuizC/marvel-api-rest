package com.aruiz.marvelapirest.dto;

import java.util.Date;
import lombok.Data;

@Data
public class BitacoraDTO {

	private Integer id;
	private String urlRequest;
	private Date fechaConsulta;
	private int statusCode;
	private String path;
}