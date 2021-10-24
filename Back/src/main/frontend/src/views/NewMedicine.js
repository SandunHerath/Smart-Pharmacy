import axios from "axios";
import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Form, Button } from "react-bootstrap";
import FormContainer from "../components/FormContainer";

const MedicineAddScreen = ({ match, history }) => {
  const productId = match.params.id;

  const [name, setName] = useState("");
  const [price, setPrice] = useState(0);
  const [image, setImage] = useState(null);

  const [category, setCategory] = useState("");

  const [description, setDescription] = useState("");
  const [selectedFile, setSelectedFile] = useState();
  const [isFilePicked, setIsFilePicked] = useState(false);

  const submitHandler = async (e) => {
    e.preventDefault();
    const medicine = {
      name: name,
      price: price,
      image: image,
      category: category,
      description: description,
    };
    const config = {
      headers: {
        "Content-Type": "application/json",
      },
    };

    const { data } = await axios.post(`/api/medicine/add`, medicine, config);
    if (data != null) {
      console.log(data);
      alert("successfully Added !");
      history.push("/medicine/home");
    }
  };

  //image uploads
  const changeHandler = (event) => {
    setSelectedFile(event.target.files);
    setIsFilePicked(true);
  };

  const handleSubmission = async () => {
    const file = selectedFile;
    console.log(isFilePicked);
    const formData = new FormData();
    formData.append("file", file);
    const config = {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    };

    const { data } = await axios.post(
      `/api/products/img/${productId}`,
      formData,
      config
    );
    if (data) {
      setImage(data);
    }
  };

  return (
    <>
      <Link to="/medicine/home" className="btn btn-light my-3">
        Go Back
      </Link>
      <FormContainer>
        <h1>Add new Medicine</h1>

        <Form onSubmit={submitHandler}>
          <Form.Group controlId="name">
            <Form.Label>Name</Form.Label>
            <Form.Control
              type="name"
              placeholder="Enter name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Form.Group controlId="price">
            <Form.Label>Price</Form.Label>
            <Form.Control
              type="number"
              placeholder="Enter price"
              value={price}
              onChange={(e) => setPrice(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Form.Group controlId="image">
            <Form.Label>Image</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter image url"
              value={image}
              onChange={(e) => setImage(e.target.value)}
            ></Form.Control>
            <input type="file" name="file" onChange={changeHandler} />
            <div>
              <button onClick={handleSubmission}>Submit</button>
            </div>
          </Form.Group>

          <Form.Group controlId="category">
            <Form.Label>Category</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter category"
              value={category}
              onChange={(e) => setCategory(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Form.Group controlId="description">
            <Form.Label>Description</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter description"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Button type="submit" variant="primary">
            Add
          </Button>
        </Form>
      </FormContainer>
    </>
  );
};

export default MedicineAddScreen;
