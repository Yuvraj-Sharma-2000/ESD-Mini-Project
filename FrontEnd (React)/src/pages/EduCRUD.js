import {useEffect, useState} from "react";
import axios from "axios";

const EduCRUD = () => {
    const [edu, setEdu] = useState([])
    const [address, setAddress] = useState('')
    const [collegeName, setCollegeName] = useState('')
    const [degree, setDegree] = useState('')
    const [join, setJoin] = useState('')
    const [pass, setPass] = useState('')

    var id = window.sessionStorage.getItem('id');

    useEffect(()=>{
        callApi();
    },[]);

    const callApi = async() => {
        await axios.post(`http://localhost:8080/cod/api/edu/details?id=${id}`)
            .then(function (response){
                console.log("from education component", response.data)
                setEdu(response.data)
            })
            .catch(function (error){
                console.log(error);
            });
    }

    const updateAPI = async () => {
        // console.log(id)
        await axios.put(`http://localhost:8080/cod/api/edu/update`,{
            id:id,
            address: address,
            collegeName: collegeName,
            degree: degree,
            joiningYear: join,
            passingYear: pass
        })
            .then((response) => {
                console.log("Update from education", response.data)
                setPass('')
                setJoin('')
                setDegree('')
                setAddress('')
                setCollegeName('')
                alert("Updated")
                window.location.reload(true)
        })
            .catch((error) => {
                console.log((error))
            })
    }

    return (
        <>
            <h2>Education Details</h2>

            <table className="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Address</th>
                    <th scope="col">College</th>
                    <th scope="col">Degree</th>
                    <th scope="col">Join</th>
                    <th scope="col">Pass</th>
                    <th scope="col">Alumni ID</th>
                </tr>
                </thead>
                {
                    edu.map((o, index) => {
                        return(
                            <tbody key={index}>
                            <tr>
                                <td>{o.id}</td>
                                <td>{o.address}</td>
                                <td>{o.collegeName}</td>
                                <td>{o.degree}</td>
                                <td>{o.joiningYear}</td>
                                <td>{o.passingYear}</td>
                                <td>{id}</td>
                            </tr>
                            </tbody>
                        )
                    })
                }
            </table>
            <div className='col-4'>
                <p>Enter values to update</p>
                <input type="text" id="address" className="form-control" placeholder="Address"
                       // value={address}
                       onChange={(event)=>{setAddress(event.target.value)}}
                />
                <input type="text" id="college" className="form-control" placeholder="College Name"
                       // value={collegeName}
                       onChange={(event)=>{setCollegeName(event.target.value)}}
                />
                <input type="text" id="degree" className="form-control" placeholder="Degree"
                       // value={degree}
                       onChange={(event)=>{setDegree(event.target.value)}}
                />
                <input type="number" id="join" className="form-control" placeholder="Joining Year"
                       // value={join}
                       onChange={(event)=>{setJoin(event.target.value)}}
                />
                <input type="number" id="pass" className="form-control" placeholder="Passing Year"
                       // value={pass}
                       onChange={(event)=>{setPass(event.target.value)}}
                />
                <button
                    onClick={updateAPI}
                >Update</button>
            </div>
        </>
    )
}
export default EduCRUD;