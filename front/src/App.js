import "./App.css";
import "antd/dist/antd.css";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Home from "./AppHome";
import MedicineHome from "./views/MedicineHomeScreen";
import Medicines from "./views/MedicineScreen";
import MedicineEdit from "./views/MedicineEditScreen";
import Login from "./views/LoginScreen";
import Register from "./views/RegisterScreen";
import Profile from "./views/ProfileScreen";
function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/">
          <Home />
        </Route>
        <Route exact path="/medicine/home">
          <MedicineHome />
        </Route>
        <Route exact path="/medicine/:id">
          <Medicines />
        </Route>
        <Route exact path="/medicine/edit/:id" component={MedicineEdit} />

        <Route exact path="/login">
          <Login />
        </Route>
        <Route exact path="/register">
          <Register />
        </Route>
        <Route exact path="/profile">
          <Profile />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
