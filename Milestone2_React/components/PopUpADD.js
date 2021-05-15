import { TableRow } from "@material-ui/core";
import React, { useState } from "react";
import "./Stylesss.css";
import Axios from 'axios';
const Popup = props => {
  //const [selectedDate, handleDateChange] = useState(new Date());
  const url = "http://localhost:8080/Summer_Internship_Backend/AddServlet"
  const [data,setData] = useState({
      namee:"",
      date:"",
      cNo:"",
      notes:"",
      iNo:"",
      iAmt:""
  })
  function submit(e){
    e.preventDefault()
    Axios.post(url,{
      namee:document.getElementById('namee'),
      date:document.getElementById('date'),
      cNo:document.getElementById('namcNoee'),
      notes:document.getElementById('notes'),
      iNo:document.getElementById('iNo'),
      iAmt:document.getElementById('iAmt'),
    })
    .then(res=>{
      console.log(res.data)
    })
  }
  function handle(e){
    const newdata = {...data}
    newdata[e.target.id] = e.target
    setData(newdata)
    console.log(newdata)
  }
  const redStar = {
    color: '#FE2E64'
  }
  return (
    <div className="popup-box">
      <div className="box" onAdd={(e)=>submit(e)}>
        {/* <span className="close-icon" onClick={props.handleClose}>x</span> */}
            <TableRow style={{backgroundColor:'#2A3E4C'}}>
                <p className='titleModal'><h3 style={{marginLeft:'2vw'}}>Add Invoice</h3></p>
                <div>

                  <font className='f3'>Customer Name<font style={redStar}>*</font>
                  <input onChange={(e)=>handle(e)} id="namee" style={{marginLeft:'0.7vw'}} type='text'/>
                  </font>

                  <font className='f3' style={{float:'right',marginRight:'4vh'}}>Due Date<font style={redStar}>*</font>
                  <input  onChange={(e)=>handle(e)} id="date" style={{marginLeft:'1.7vh',width:'9.5vw'}} type='date'/>
                  </font>

                </div>
            </TableRow>

            <TableRow style={{backgroundColor:'#2A3E4C'}}>

                <font className='f3' style={{marginRight:'23vh'}}>Customer No.<font style={redStar}>*</font>
                <input  onChange={(e)=>handle(e)} id="cNo" style={{marginLeft:'4vh'}}/>
                </font>

                <font className='f3' style={{float:'right',marginRight:'4vh'}}>Notes
                <input  onChange={(e)=>handle(e)} id="notes" rowspan="3" type="textarea" name="textValue" style={{marginLeft:'6.5vh'}} />
                </font>

            </TableRow>

            <TableRow style={{backgroundColor:'#2A3E4C'}}>

                <font className='f3'>Invoice No.<font style={redStar}>*</font> 
                <input  onChange={(e)=>handle(e)} id="iNo" style={{marginLeft:'6.8vh'}} type="text"/>
                </font>

            </TableRow>

            <TableRow style={{backgroundColor:'#2A3E4C'}}>

                <div className='tButtom'><font className='f3' style={{marginRight:'23vh'}}>Invoice Amount.<font style={redStar}>*</font>
                <input onChange={(e)=>handle(e)} id="iAmt" style={{marginLeft:'1vh'}} type="text"/>
                </font></div>

            </TableRow>

                <div>
                    <button type="button" style={{marginLeft:'4vw'}} onClick={props.handleClose}>
                      Cancel</button>

                    <button type="button" style={{marginLeft:'35vw'}}>Clear</button>

                    <button type="button" style={{marginLeft:'1vw'}} onClick={props.handleClose} className='paedBtn'>
                      Add</button>
                </div>

        {props.content}
      </div>
    </div>
  );
};
 
export default Popup;