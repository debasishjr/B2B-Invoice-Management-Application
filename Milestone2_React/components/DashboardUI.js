import React from "react";
import axios from "axios";
import companyLogo from "../assets/companyLogo.svg";
import "./Stylesss.css";
import MuiTableCell from "@material-ui/core/TableCell";
import logoHR from "../assets/logoHR.svg";
import check_box_outline_blank from "../assets/check_box_outline_blank.svg";
import check_box_black_18dp from "../assets/check_box_black_18dp.svg";
import {
  TableContainer,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  CircularProgress,
  Paper,
  button,
  withStyles
} from "@material-ui/core";
import InfiniteScroll from "react-infinite-scroll-component";
//import Footer from "./Footer";
import { pxToRem, pxToVh } from "../utils/theme";
import { AssessmentTwoTone } from "@material-ui/icons";
import PopUpADD from "./PopUpADD";
import PopUpDELETE from "./PopUpDELETE";
import PopUpEDIT from "./PopUpEDIT";
import ChangeCheck from "./ChangeCheck";
import useDebounce from './Search'
import { useState,useEffect } from "react";

export default function App() {
  const [data, setData] = React.useState([]);
  const [search, setSearch] = React.useState('');
  const [searchFilter, setSearchFilter] = React.useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [results, setResults] = useState([]);
  const [isSearching, setIsSearching] = useState(false);
  const [noValue,setnoValue]          =useState(false);
  const debouncedSearchTerm = useDebounce(searchTerm, 3000);
  const count = React.useRef(0);
  var c1=React.useRef(0);
  var c2=React.useRef(20);
  var t=React.useRef(0);

  const mystyleTableCell_H = {
    color: '#97a1a9'
  }
  const mystyleTableCell_B = {
    color: '#ffffff'
  }
  const bodyFont = {
    fontSize:pxToVh(10)
  }
  const TableCell = withStyles({
  root: {
    borderBottom: "none",
    fontSize:pxToVh(12),
  }
  })(MuiTableCell);
  
  const getApiData = React.useCallback(async () => {
    try {
      const response = await axios.get("http://localhost:8080/Summer_Internship_Backend/dummy.do");
      setData((prevData) => [...prevData, ...response.data.slice(c1.current,c2.current)]);
      t.current=c2.current;
      c1.current=t.current;
      c2.current=c2.current+t.current;
      count.current += 1;
    } 
    catch (error) {
      console.log(error);
    }
  }, []);

  React.useEffect(() => {
    getApiData();
  }, [getApiData]);

  console.log(data);

  const [isOpen, setIsOpen] = useState(false);
  const togglePopup = () => {
    setIsOpen(!isOpen);
  }

  const [isOpenE, setIsOpenE] = useState(false);
  const togglePopupE = () => {
    setIsOpenE(!isOpenE);
  }

  const [isOpenD, setIsOpenD] = useState(false);
  const togglePopupD = () => {
    setIsOpenD(!isOpenD);
  }

  const [isOpenC, setIsOpenC] = useState(false);
  const toggleC=()=>{
    setIsOpenC(!isOpenC);
  }

  // useEffect(() => {
  //   setSearchFilter(
  //     data.filter((id) =>
  //       id.invoice_id.toLowerCase().includes(search.toLowerCase())
  //     )
  //   );
  // }, [search, data]);

  useEffect(
    () => {
      if (debouncedSearchTerm) {
        setIsSearching(true);
        const filter = data.filter(da => {
          return da.data.toLowerCase().startsWith(debouncedSearchTerm.toLowerCase());
        });
        setIsSearching(false);
        if(IsnoValue(filter)===1 ){
          setnoValue(true);
        }else{
          setnoValue(false);
          setResults(filter);
        }
        // setIsSearching(false);
      } else {
        setResults([]);
      }
    },
    [debouncedSearchTerm]
  );
  function IsnoValue(result){
    if(result.length==0){
      return 1;
    }
    return null;
 }  

  return (
    <>
    <div>
      <div style={{margin:"3vh",marginTop:'2vh'}}>
        <img src={companyLogo} alt="companyLogo" className="img1"></img>
        <font className="f1"> ABC Products </font>
        <img src={logoHR} alt="hrLogo" className="img2"></img>
      </div>
        <font className="f2" style={{marginLeft:'2vw',fontSize:'3vh'}}> Invoice List </font>
      <div style={{backgroundColor:"#2d424f",margin:"3.5vh"}}>
      <div>
        <div>
            <button type="button" style={{marginTop:"3vh"}} className='paedBtn'>Predict</button>
            <button type="button">View correspondence</button>
            <button type="button" style={{marginLeft:"40vw"}} onClick={togglePopup} className='addbtn'>+ Add</button>

            {isOpen && <PopUpADD
                handleClose={togglePopup}
            />}

            <button type="button" onClick={togglePopupE}>Edit</button>

            {isOpenE && <PopUpEDIT
                handleClose={togglePopupE}
            />}

            <button type="button" onClick={togglePopupD}>- Delete</button>

            {isOpenD && <PopUpDELETE
                handleClose={togglePopupD}
            />}

            <input type="text" placeholder='Search by Sales_Order_Id' 
            //onChange={e => {setSearchTerm(e.target.value); if(e.target.value == '')setnoValue(false)}}
            >
            </input>
              {isSearching && <div>Searching ...</div>}
              {noValue && <div><h1 style={{textAlign:"center",color:"red"}}>No Results Found</h1></div>}

        </div>

      <TableContainer
        id="test-table"
        component={Paper}
        style={{
          height: "70vh",
          overflowY: "scroll"
        }}
      >
         <InfiniteScroll style={{background: "#2d4250"}}
          scrollableTarget="test-table"
          dataLength={data.length}
          loader={
            <div
              style={{
                width: "100px",
                height: "100px",
                margin: "auto",
                padding: "50px"
              }}
            >
              <CircularProgress style={{color:"#189ed8"}}/><br/>
              <font style={{color:'#717f89'}}>Loading</font>
            </div>
          }
          hasMore={true} 
          next={getApiData}
        >
          <Table>
            <TableHead>
              <TableRow className="header1">
                <TableCell><img src={check_box_outline_blank} alt='d' className="img3"></img></TableCell>
                <TableCell style={mystyleTableCell_H}>Customer_Name</TableCell>
                <TableCell style={mystyleTableCell_H}>Customer</TableCell>
                <TableCell align="left" style={mystyleTableCell_H}>Sales_Order_Id</TableCell>
                <TableCell align="right" style={mystyleTableCell_H}>Sales_Order_Amount</TableCell>
                <TableCell align="right" style={mystyleTableCell_H}>Due_Date</TableCell>
                <TableCell align="right" style={mystyleTableCell_H}>Predicted_Payment_Date</TableCell>
                <TableCell align="left" style={mystyleTableCell_H}>Predicted_Aging_Bucket</TableCell>
                <TableCell align="left" style={mystyleTableCell_H}>Notes</TableCell>
              </TableRow>
            </TableHead>
            <TableBody style={bodyFont}>

              
  
              {data.map(item=>{
                  return(
                    <TableRow>
                      <TableCell><img id="imgC" src={check_box_outline_blank} alt='checkbox' className="img3" onClick={toggleC}></img></TableCell>
                      
                      {isOpenC && <ChangeCheck
                        handleClose={toggleC}
                      /> }
                      
                      <TableCell style={mystyleTableCell_B}>{item.name_customer}</TableCell>
                      <TableCell style={mystyleTableCell_B}>{item.cust_number}</TableCell>
                      <TableCell style={mystyleTableCell_B}>{item.invoice_id}</TableCell>
                      <TableCell align="right" style={mystyleTableCell_B}>{item.total_open_amount}</TableCell>
                      <TableCell align="right" style={mystyleTableCell_B}>{item.due_in_date}</TableCell>
                      <TableCell align="right" style={mystyleTableCell_B}>--</TableCell>
                      <TableCell style={mystyleTableCell_B}>--</TableCell>
                      <TableCell style={mystyleTableCell_B}>Lorem Ipsum dolor...</TableCell>
                    </TableRow>
                  );
                })}
            </TableBody>
          </Table>
        </InfiniteScroll>
      </TableContainer>
      </div>
      </div>
    </div>
    </>
  );
}