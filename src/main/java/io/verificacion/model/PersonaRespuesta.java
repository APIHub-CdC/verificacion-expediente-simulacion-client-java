package io.verificacion.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import io.verificacion.model.PersonasRespuestas;

import java.util.ArrayList;
import java.util.List;


public class PersonaRespuesta {
  @SerializedName("Folio")
  private String folio = null;
  @SerializedName("FolioOtorgante")
  private String folioOtorgante = null;
  @SerializedName("list")
  private List<PersonasRespuestas> _list = null;
  public PersonaRespuesta folio(String folio) {
    this.folio = folio;
    return this;
  }
   
  @ApiModelProperty(example = "962808000", value = "")
  public String getFolio() {
    return folio;
  }
  public void setFolio(String folio) {
    this.folio = folio;
  }
  public PersonaRespuesta folioOtorgante(String folioOtorgante) {
    this.folioOtorgante = folioOtorgante;
    return this;
  }
   
  @ApiModelProperty(example = "Trulioo", value = "")
  public String getFolioOtorgante() {
    return folioOtorgante;
  }
  public void setFolioOtorgante(String folioOtorgante) {
    this.folioOtorgante = folioOtorgante;
  }
  public PersonaRespuesta _list(List<PersonasRespuestas> _list) {
    this._list = _list;
    return this;
  }
  public PersonaRespuesta addListItem(PersonasRespuestas _listItem) {
    if (this._list == null) {
      this._list = new ArrayList<PersonasRespuestas>();
    }
    this._list.add(_listItem);
    return this;
  }
   
  @ApiModelProperty(value = "")
  public List<PersonasRespuestas> getList() {
    return _list;
  }
  public void setList(List<PersonasRespuestas> _list) {
    this._list = _list;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonaRespuesta personaRespuesta = (PersonaRespuesta) o;
    return Objects.equals(this.folio, personaRespuesta.folio) &&
        Objects.equals(this.folioOtorgante, personaRespuesta.folioOtorgante) &&
        Objects.equals(this._list, personaRespuesta._list);
  }
  @Override
  public int hashCode() {
    return Objects.hash(folio, folioOtorgante, _list);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonaRespuesta {\n");
    
    sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
    sb.append("    folioOtorgante: ").append(toIndentedString(folioOtorgante)).append("\n");
    sb.append("    _list: ").append(toIndentedString(_list)).append("\n");
    sb.append("}");
    return sb.toString();
  }
  
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
