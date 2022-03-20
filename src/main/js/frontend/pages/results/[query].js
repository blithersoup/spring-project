import { Box, Stack, Heading, Text } from "@chakra-ui/react";
import PageHeader from "../PageHeader";
import { useRouter } from "next/router";

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
  const url = "http://localhost:8080/news/search?query=helloworld"; //+ q
  /*
  let ret = (body) => (
    <>
      <PageHeader />
      <Stack spacing={8}>
        {body.articles.map((item) => (
          <Feature title={item.title} desc={item.url} />
        ))}
      </Stack>
    </>
  );*/

  const response = fetch(url)
    .then((response) => {
      if (!response.ok) {
        throw new Error(response.statusText);
      }
      return response.json();
    })
    .catch((error) => console.log(error));

  //let body = getJson();

  //let options = { params: { query: result } };

  console.log(response);

  return <p>ok</p>;
}

export default Results;
