import './App.css';
import Login from "./pages/Login";
import BasicButtons from "./pages/dashboard";
import {
    BrowserRouter,
    Routes,
    Route,
} from "react-router-dom";

function App() {
    var status = window.sessionStorage.getItem('isLogged_in')
  return (
    <div className="App">
      <div className="">
          <div className="Container">
              {
                  (status ===null) && <Login />
              }
              {
                  (status === "true") && <BasicButtons />
              }

          </div>

      </div>
    </div>
  );
}

export default App;
