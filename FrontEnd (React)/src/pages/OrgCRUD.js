import axios from "axios";
import react, {useEffect, useState} from 'react'
// import swal from 'sweetalert2';

const OrgCRUD = () => {
    const [org, setOrg] = useState([])
    const [join,setJoin] = useState('')
    const [leave, setLeave] = useState('')
    const [position, setPosition] = useState('')
    const [idOrg, setIdOrg] = useState('')

    var id = window.sessionStorage.getItem('id')
    ;
    // console.log(idOrg);
    useEffect(()=>{
        callApi();
    //
    },[]);

    const deleteApi = async() => {
        await axios.delete(`http://localhost:8080/cod/api/org/delete?id=${idOrg}`)
            .then(function (response){
                console.log("from organisation",response.data)
                alert("Successfully deleted the Organization")
                window.location.reload(true)
            })
    }

    const addApi = async() => {
        // console.log(id)
        // console.log(idOrg)
        await axios.post(`http://localhost:8080/cod/api/org/add`,{
            joiningDate: join,
            leavingDate: leave,
            position: position,
            alumni:{
                id: id
            },
            organisation:{
                id: idOrg
            }
        })
            .then((response)=>{
                console.log("from add button",response.data);
                alert("SUCESS")
                setPosition('')
                setLeave('')
                setJoin('')
                setIdOrg('')
                window.location.reload(true)
            })
            .catch((error)=>{
                console.log((error));
            });
    }

    const callApi = async() => {
        await axios.post(`http://localhost:8080/cod/api/org/details?id=${id}`)
            .then(function (response) {
                console.log("from organization component",response.data)
                setOrg(response.data)
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    const updateAPI = async () => {
        await axios.put('http://localhost:8080/cod/api/org/update',{
            id:idOrg,
            joiningDate: join,
            leavingDate: leave,
            position: position
        })
            .then((response)=>{
                console.log("from update button",response.data);
                alert("SUCESS")
                // swal("Sucessfull","updated details successfully", "success");
                setPosition('')
                setLeave('')
                setJoin('')
                setIdOrg('')
                window.location.reload(true)
            })
            .catch((error)=>{
                console.log((error));
            });
    }
    return (
        <>
            <h2>Organisation Details</h2>

            <table className="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Organisation ID</th>
                    <th scope="col">Join</th>
                    <th scope="col">Leave</th>
                    <th scope="col">Position</th>
                </tr>
                </thead>
            {
                org.map((o, index) => {
                    return(
                        <tbody key={index}>
                            <tr>
                                <td>{o.id}</td>
                                <td>{o.joiningDate}</td>
                                <td>{o.leavingDate}</td>
                                <td>{o.position}</td>
                            </tr>
                        </tbody>
                    )
                })
            }
            </table>
            <div className="row mt-5">
                <div className='col-4'>
                    <p>Add new values</p>
                    {/*type is number because we want id as integer type*/}
                    <input type="number" id="idOrg" className="form-control" placeholder="Organisation ID"
                        // value={idOrg}
                           onChange={(event)=>{setIdOrg(event.target.value)}}
                    />
                    <input type="date" id="join" className="form-control" placeholder="Joining Date"
                           // value={join}
                           onChange={(event)=>{setJoin(event.target.value)}}
                    />
                    <input type="date" id="leave" className="form-control" placeholder="Leaving Date"
                           // value={leave}
                           onChange={(event)=>{setLeave(event.target.value)}}
                    />
                    <input type="text" id="position" className="form-control" placeholder="Position"
                           // value={position}
                           onChange={(event)=>{setPosition(event.target.value)}}
                    />
                    <button
                        onClick={addApi}
                    >Add</button>
                </div>
                <div className='col-4'>
                    <p>Enter values to update</p>
                    {/*type is number because we want id as integer type*/}
                    <input type="number" id="org" className="form-control" placeholder="Organisation ID"
                           // value={idOrg}
                           onChange={(event)=>{setIdOrg(event.target.value)}}
                    />
                    <input type="date" id="join" className="form-control" placeholder="Joining Date"
                           value={join}
                           onChange={(event)=>{setJoin(event.target.value)}}
                    />
                    <input type="date" id="leave" className="form-control" placeholder="Leaving Date"
                           value={leave}
                           onChange={(event)=>{setLeave(event.target.value)}}
                    />
                    <input type="text" id="position" className="form-control" placeholder="Position"
                           value={position}
                           onChange={(event)=>{setPosition(event.target.value)}}
                    />
                    <button
                        onClick={updateAPI}
                    >Update</button>
                </div>
                <div className="col-4">
                    <p>Enter org id to del</p>
                    <input type="number" id="org" className="form-control" placeholder="Organisation ID"
                           onChange={(event)=>{setIdOrg(event.target.value)}}
                    />
                    <button
                        onClick={deleteApi}
                    >Delete</button>
                </div>
            </div>
        </>
    )
}
export default OrgCRUD;