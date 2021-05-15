import { TableRow } from "@material-ui/core";
import React, { useState } from "react";
import "./Stylesss.css";

const Popup = props => {
  return (
    <div className="popup-box">
      <div className="editPopUp">
        <TableRow style={{backgroundColor:'#2A3E4C'}}>
          <p className='titleModal'><h3 style={{marginLeft:'2vw'}}>Edit Invoice</h3></p>
        </TableRow>
        <TableRow style={{backgroundColor:'#2A3E4C'}}>
            <font style={{color:'#717f89',marginLeft:'2vw'}}>Invoice Amount</font>
            <input className='f3' style={{marginLeft:'1vw'}}/>
        </TableRow>
        <TableRow style={{backgroundColor:'#2A3E4C'}}>
            <font className='f3'>Notes</font>
            <input className='f3' style={{marginLeft:'6.5vw',height:'10vh'}}/>
        </TableRow>
        <TableRow style={{backgroundColor:'#2A3E4C'}}>
          <div className='tTop' style={{marginTop:'1.5vh'}}>
              <button type="button" style={{float:'left',marginLeft:'2vw'}} onClick={props.handleClose}>
                Cancel</button>
              <button type="button" style={{marginLeft:'7.8vw'}}>Reset</button>
              <button type="button" style={{marginLeft:'1vw'}} onClick={props.handleClose} className='paedBtn'>
                Save</button>
          </div>
        </TableRow>
        {props.content}
      </div>
    </div>
  )
};
export default Popup;
































/*
<div className="popup-box">
      <div className="box" >
        <div>
          <input className='f3' style={{marginLeft:'3vw'}}>Invoice Amount</input>
        </div>

        <font className='f3' style={{float:'right',marginLeft:'3vw'}}>Notes
            <input id="notes" rowspan="3" type="textarea" name="textValue" style={{height:'5vh'}} />
        </font>
        <TableRow style={{backgroundColor:'#2A3E4C'}}>
        <div className='tTop' style={{marginTop:'1.5vh'}}>
            <button type="button" style={{marginLeft:'30vw',marginTop:'2vh'}} onClick={props.handleClose}>
              Cancel</button>
            <button type="button" style={{marginLeft:'1vw'}} className='paedBtn'>Reset</button>
            <button type="button" style={{marginLeft:'1vw'}} onClick={props.handleClose} className='paedBtn'>
              Save</button>
        </div>
        </TableRow>
</div>
</div>
*/