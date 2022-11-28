import react,{useState} from 'react'
import axios from "axios";
import Dashboard from "./dashboard";
import Swal from 'sweetalert2'

const Login = () => {

    const [email, setEmail] = useState('')
    const [password, setPwd] = useState('')

    const handleLogin = async() => {

        await axios.post('http://localhost:8080/cod/api/alumni/login', {
            email: email,
            password: password
        })
            .then(function (response) {
                console.log(response.data);
                console.log(response.status);
                if(response.status===200)
                {
                    window.sessionStorage.setItem('isLogged_in','true');
                    window.sessionStorage.setItem('id',response.data.id);
                    window.location.reload(true);
                }
                else if(response.status !== null){
                    return Swal.fire(
                        'Incorrect Credentials',
                        'Please enter valid credentials',
                        'error'
                    );
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    // console.log(email)

    return(
        <div className="w-50">
            <form>
                <div className="form-outline mb-4">
                    <input type="email" id="form2Example1" className="form-control"
                    onChange={(event)=>{setEmail(event.target.value)}}
                    />
                    <label className="form-label" htmlFor="form2Example1">Email address</label>
                </div>

                {/*// <!-- Password input -->*/}
                <div className="form-outline mb-4">
                    <input type="password" id="form2Example2" className="form-control"
                           onChange={(event)=>{setPwd(event.target.value)}}
                    />
                    <label className="form-label" htmlFor="form2Example2">Password</label>
                </div>

                <button type="button" className="btn btn-primary btn-block mb-4"
                onClick={handleLogin}
                >Sign in</button>
            </form>
        </div>
    );
}

export default Login;