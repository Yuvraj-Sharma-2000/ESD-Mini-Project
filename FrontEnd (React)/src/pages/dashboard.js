import react, {useEffect, useState} from 'react'
import axios from "axios";
import Button from "bootstrap/js/src/button";
import Swal from "sweetalert2";
import OrgCRUD from "./OrgCRUD";
import EduCRUD from "./EduCRUD";
import AlumniCRUD from "./AlumniCRUD";


const Dashboard = () => {

    const [opt, setOption] = useState("details");

    const handleEvent =() =>
    {
        window.sessionStorage.clear();
        window.location.reload(true);
    }

    return(
        <>
            <div className="d-flex justify-content-around">
                <select value={opt} onChange={(e)=>{setOption(e.target.value)}}>
                    <option value="org">Organization</option>
                    <option value="edu">Education</option>
                    <option value="details">Details</option>
                </select>
                {/*<button className="btn btn-primary ml-auto" onClick={()=>{setOption(1)}}>Organization</button>*/}
                {/*<button className="btn btn-dark ml-auto" onClick={()=>{setOption(2)}}>Education</button>*/}
                {/*<button className="btn btn-success ml-auto" onClick={()=>{setOption(3)}}>Details</button>*/}
                <button type="button" className="btn btn-danger ml-auto" onClick={handleEvent}>Logout</button>

            </div>
            {
                (opt==="org") && <OrgCRUD />
            }
            {
                (opt==="details") && <AlumniCRUD />
            }
            {
                (opt==="edu") && <EduCRUD />
            }
        </>
    )
}
export default Dashboard;
