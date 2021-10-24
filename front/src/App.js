import "./App.css";
import "antd/dist/antd.css";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Home from "./AppHome";
import MedicineHome from "./views/Medicines";
import Medicines from "./views/MedicineScreen";
import MedicinesAdd from "./views/NewMedicine";
import MedicineEdit from "./views/MedicineEditScreen";
import Login from "./views/LoginScreen";
import Register from "./views/RegisterScreen";
import Profile from "./views/ProfileScreen";
import Doctor from "./views/Doctor";
import DoctorsScreen from "./views/DoctorHome";
import DoctorEdit from "./views/DoctorEdit";
import DoctorAdd from "./views/NewDoctor";
import Main from "./views/Main";
function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/">
          <Home />
        </Route>
        <Route exact path="/main" component={Main}/>
        <Route exact path="/medicine/home" component={MedicineHome} />
        <Route exact path="/medicine/add" component={MedicinesAdd} />
        <Route exact path="/medicine/:id" component={Medicines} />
        <Route exact path="/medicine/edit/:id" component={MedicineEdit} />

        <Route exact path="/doctor/add" component={DoctorAdd} />
        <Route exact path="/doctor/:id" component={Doctor} />
        <Route exact path="/doctor/edit/:id" component={DoctorEdit} />
        <Route exact path="/login">
          <Login />
        </Route>
        <Route exact path="/doctors" component={DoctorsScreen} />

        <Route exact path="/register" component={Register} />
        <Route exact path="/profile">
          <Profile />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
