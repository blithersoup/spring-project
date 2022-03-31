import { Box, Stack, Heading, Text } from "@chakra-ui/react";
import PageHeader from "../PageHeader";
import { useRouter } from "next/router";
import { useEffect, useState } from 'react';

function Feature({ title, desc }) {
  return (
    <Box p={5} shadow="md" borderWidth="1px">
      <Heading fontSize="xl">{title}</Heading>
      <Text mt={4}>{desc}</Text>
    </Box>
  );
}

function Results() {
  const router = useRouter();
  const { query } = router.query;
  const url = "http://localhost:8080/news/search?query=" + query;
  
  let d = {
    "articles": [
        {"title": "",
    "url": ""}
    ]
};

 const [body, setBody] = useState(d);



useEffect(async () => {
    await fetch(url).then(response => response.json()).then((json) => { setBody(json) });
   
    //setTimeout(() => { setBody({"articles":[{"title": "loaded", "url": "fully"}]}) }, 2000);
});

let ret = (
<>
    <PageHeader />
    <Stack spacing={8}>
        {body.articles.map((item) => (
        <Feature key={item} title={item.title} desc={item.url} />
        ))}
    </Stack>
</>
);
return ret;

}

export default Results;
