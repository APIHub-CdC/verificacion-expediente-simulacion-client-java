package io.verificacion.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import io.verificacion.model.DomicilioRespuesta;

import java.util.ArrayList;
import java.util.List;


public class DomiciliosRespuesta {
  @SerializedName("list")
  private List<DomicilioRespuesta> _list = null;
  public DomiciliosRespuesta _list(List<DomicilioRespuesta> _list) {
    this._list = _list;
    return this;
  }
  public DomiciliosRespuesta addListItem(DomicilioRespuesta _listItem) {
    if (this._list == null) {
      this._list = new ArrayList<DomicilioRespuesta>();
    }
    this._list.add(_listItem);
    return this;
  }
   
  @ApiModelProperty(value = "")
  public List<DomicilioRespuesta> getList() {
    return _list;
  }
  public void setList(List<DomicilioRespuesta> _list) {
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
    DomiciliosRespuesta domiciliosRespuesta = (DomiciliosRespuesta) o;
    return Objects.equals(this._list, domiciliosRespuesta._list);
  }
  @Override
  public int hashCode() {
    return Objects.hash(_list);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DomiciliosRespuesta {\n");
    
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
