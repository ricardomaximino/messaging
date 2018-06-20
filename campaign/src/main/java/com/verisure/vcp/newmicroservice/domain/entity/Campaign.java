package com.verisure.vcp.newmicroservice.domain.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Sample domain entity. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Campaign implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;
  private String name;
  private String description;
  private List<Operator> OperatorList;
  private List<Contact> ContactList;
    
}
