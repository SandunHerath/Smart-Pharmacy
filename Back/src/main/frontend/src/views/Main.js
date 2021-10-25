import React from "react";
import { Image, Button } from "antd";
import { Row, Col, Card } from "react-bootstrap";

const ProductScreen = ({ history }) => {
  const DoctorHandler = () => {
    history.push("/doctors");
  };
  const MedicineHandler = () => {
    history.push("/medicine/home");
  };
  return (
    <>
      <Row ph={6}>
        <Col md={2}></Col>
        <h3 className="my-2">WelCome To Smart-Medical-Center</h3>
      </Row>
      <Row>
        <Col md={2}></Col>
        <Col md={4}>
          <Card>
            <Image
              width={485}
              height={480}
              src="https://www.newsfirst.lk/wp-content/uploads/2018/08/medicine-1600.jpg"
            ></Image>
            <br></br>
            <Button onClick={MedicineHandler} type="primary" size="large">
              Get Medicine
            </Button>
          </Card>
        </Col>
        <Col md={4}>
          <Card fluid>
            <Image
              width={485}
              height={480}
              src="https://www.pennmedicine.org/-/media/images/miscellaneous/random%20generic%20photos/female_doctor_talking_with_female.ashx?mw=620&mh=408"
            ></Image>
            <br></br>
            <Button onClick={DoctorHandler} type="primary" size="large">
              Chanel A Doctor
            </Button>
          </Card>
        </Col>
        <Col md={2}></Col>
      </Row>
    </>
  );
};

export default ProductScreen;
