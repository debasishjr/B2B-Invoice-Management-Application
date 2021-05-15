import React from "react";
import "./Stylesss.css";
import check_box_black_18dp from "../assets/check_box_black_18dp.svg";
const Popup = props => {
  return (
    <div>
        <img 
            src={check_box_black_18dp} 
            alt='CheckMarked'
            className="img3"
            style={{float:'left'}}
        >
        </img>
    </div>
  )
};
export default Popup;
