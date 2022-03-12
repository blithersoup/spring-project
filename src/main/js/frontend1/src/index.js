import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./pages/App";
import reportWebVitals from "./reportWebVitals";
import { extendTheme, ChakraProvider } from "@chakra-ui/react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Results from "./pages/Results.js";
import Feature from "./pages/Try.js";
//@chakra=ui/theme-tools
//@chakra-ui/icons for icons
//react-icons
const colors = {
  brand: {
    900: "#1a365d",
    800: "#153e75",
    700: "#2a69ac",
  },
};
/*
const res = {
  items: [
    {
      title: "hello",
      text: "world",
    },
    {
      title: "hello1",
      text: "world1",
    },
  ],
};
*/
const theme = extendTheme({ colors });

ReactDOM.render(
  <ChakraProvider theme={theme}>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}></Route>
        <Route path="/about" element={<Feature />}></Route>
        <Route path="/results" element={<Results result="ukraine" />}></Route>
      </Routes>
    </BrowserRouter>
  </ChakraProvider>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
