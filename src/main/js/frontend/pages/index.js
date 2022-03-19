import React from "react";
import App from "./App";
import { extendTheme, ChakraProvider } from "@chakra-ui/react";
//@chakra=ui/theme-tools
//@chakra-ui/icons for icons
//react-icons
//next/image
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
export default function Home() {
  return (
    <ChakraProvider theme={theme}>
      <App />
    </ChakraProvider>
  );
}

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
