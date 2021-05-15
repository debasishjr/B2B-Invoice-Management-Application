import { TableRow } from "@material-ui/core";
import React, { useState } from "react";
import "./Stylesss.css";
const Popup = props => {
  //const [selectedDate, handleDateChange] = useState(new Date());
//   const url = ""
//   const [data,setData] = useState({
//       namee:"",
//       date:"",
//       cNo:"",
//       notes:"",
//       iNo:"",
//       iAmt:""
//   })
//   function submit(e){
//     e.preventDefault()
//     Axios.post(url,{
//       namee:document.getElementById('namee'),
//       date:document.getElementById('date'),
//       cNo:document.getElementById('namcNoee'),
//       notes:document.getElementById('notes'),
//       iNo:document.getElementById('iNo'),
//       iAmt:document.getElementById('iAmt'),
//     })
//     .then(res=>{
//       console.log(res.data)
//     })
//   }
//   function handle(e){
//     const newdata = {...data}
//     newdata[e.target.id] = e.target
//     setData(newdata)
//     console.log(newdata)
//   }
const redd = {
  color: '#FE2E64'
}
  return (
    <div className="popup-box">
      <div className="deletePopUp">
        {/* <span className="close-icon" onClick={props.handleClose}>x</span> */}
            <TableRow style={{backgroundColor:'#2A3E4C'}}>
                <p className='titleModal'><h3 style={{marginLeft:'3vw'}}>Delete record(s)?</h3></p>
                <div>
                  <p className='f3' style={{marginLeft:'3vw'}}>
                    You'll lose your record(s) after this action. We can't recover them once you delete.
                  </p>
                  <p className='f3' style={{marginLeft:'3vw'}}>
                    Are you sure you want to <font style={redd}>permanently delete</font> them?
                  </p>
                </div>
            </TableRow>
            <TableRow style={{backgroundColor:'#2A3E4C'}}>
                <div className='tTop' style={{marginTop:'1.5vh'}}>
                    <button type="button" style={{marginLeft:'30vw',marginTop:'2vh'}} onClick={props.handleClose}>
                      Cancel</button>

                    <button type="button" style={{marginLeft:'1vw'}} onClick={props.handleClose} className='paedBtn'>
                      Delete</button>
                </div>
            </TableRow>
        {props.content}
      </div>
    </div>
  );
};
 
export default Popup;

