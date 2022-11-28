import {useEffect, useState} from "react";
import axios, {put} from "axios";

const AlumniCRUD = () => {
    const [alum, setAlum] = useState([]);
    const [contact, setContact] = useState('');
    const [email, setEmail] = useState('');

    var id = window.sessionStorage.getItem('id');

    useEffect(()=>{
        callApi();
    },[]);

    const callApi = async() => {
        await axios.get(`http://localhost:8080/cod/api/alumni/id?id=${id}`)
            .then(function (response){
                // console.log("from alumni component", response.data);
                setAlum(response.data);
            })
            .catch(function (error){
                console.log(error);
            })
    }

    const updateAPI = async () => {
        console.log(id)
        await axios.put(`http://localhost:8080/cod/api/alumni/update`,{
            id: id,
            contactNumber: contact
        })
            .then((response)=>{
                alert("Contact updated")
                setContact('')
                window.location.reload(true)
            })
            .catch((error)=>{
                console.log((error))
            })
    }

    // console.log("state",alum);
    // console.log(Array.isArray(alum)); //map will run only for arrays

    return(
        <>
        <h2>Alumni Details</h2>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Alumni Id</th>
                    <th scope="col">Contact</th>
                    <th scope="col">Email</th>
                </tr>
                </thead>
                    <tbody>
                        <tr>
                            <td>{alum.id}</td>
                            <td>{alum.contactNumber}</td>
                            <td>{alum.email}</td>
                        </tr>
                    </tbody>
            </table>

            <div className='col-4'>
                <p>Change Contact Number</p>
                <input type="number" id="contact" className="form-control" placeholder="Contact Number"
                    // value={contact}
                       onChange={(event)=>{setContact(event.target.value)}}
                />

                <button
                    onClick={updateAPI}
                >Update</button>
            </div>

        </>
    )
}
export default AlumniCRUD;