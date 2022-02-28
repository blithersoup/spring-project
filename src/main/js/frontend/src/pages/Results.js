import { Box, Stack, Heading, Text } from "@chakra-ui/react";
import PageHeader from "./PageHeader";

function Feature({ title, desc }) {
  return (
    <Box p={5} shadow="md" borderWidth="1px">
      <Heading fontSize="xl">{title}</Heading>
      <Text mt={4}>{desc}</Text>
    </Box>
  );
}

function Results({ result }) {
  const url = "http://localhost:3000/news/search?query=ukraine";
  /*let ret = (
    <>
      <PageHeader />
      <Stack spacing={8}>
        {body.articles.map((item) => (
          <Feature title={item.title} desc={item.url} />
        ))}
      </Stack>
    </>
  );*/
  //let options = { params: { query: result } };

  fetch(url)
    .then((response) => {
      const body = response.json();
    })
    .then(console.log(body))
    .catch((error) => {
      console.log(error);
    });

  return (
    <>
      <div>hello</div>
    </>
  );
}

export default Results;
