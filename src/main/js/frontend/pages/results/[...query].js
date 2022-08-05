import { Box, Stack, Heading, Text, Spacer } from "@chakra-ui/react";
import PageHeader from "../../components/PageHeader";
import { useRouter } from "next/router";
import { useState, useEffect } from "react";
import Sentiment from 'sentiment'

function BottomBox({ query }) {
  const [tweets, setTweets] = useState([]);
  const [sentimentVal, setSentimentVal] = useState(0);
  const endpoint = process.env.NEXT_PUBLIC_API;
  const url = `${endpoint}/twitter/search?query=${query}`;
  const sent = new Sentiment()
  
  useEffect(() => {
    (
      async () => {
        await fetch(url)
        .then((response) => response.json())
        .then((json) => {
          setTweets(json.data);
        });
      }
    )()
  })

  useEffect(() => {
    let newSentiment = 0
    let i = 0
    tweets ?
    tweets.forEach(({ text }) => {
      i += 1
      const { comparative: score } = sent.analyze(text)
      newSentiment += score
      setSentimentVal(newSentiment / i)
    })
    : null
  }, [tweets])

  return (
    <Stack direction="row">
      <Spacer />
      <Text>Show more</Text>
      <div>
        {sentimentVal}
      </div>
      <Spacer />
    </Stack>
  );
}

function Feature({ article }) {
  const [open, setOpen] = useState(false);
  const {
    source,
    author,
    title,
    url,
    urlToImage,
    publishedAt,
    description: desc,
  } = article;

  return (
    <Box
      pl="2%"
      maxW="50%"
      shadow="md"
      borderWidth="1px"
      borderRadius="2px"
      borderColor="black"
      onClick={() => setOpen(!open)}
    >
      <Heading ml="1" fontSize="xl">
        {title}
      </Heading>
      <Text ml="2" mt={4}>
        {desc}
      </Text>
      {open ? <BottomBox query={desc} /> : <Text>Show more</Text>}
    </Box>
  );
}

function Results() {
  const router = useRouter();
  const { query } = router.query;
  const endpoint = process.env.NEXT_PUBLIC_API;
  const url = `${endpoint}/news/search?query=${query}`;

  let d = {
    articles: [{ title: "", url: "" }],
  };

  const [body, setBody] = useState(d);

  useEffect(() => {
    (async () => {
      await fetch(url)
        .then((response) => response.json())
        .then((json) => {
          setBody(json);
        });
    })();
  });

  return (
    <Stack>
      <PageHeader />
      <Stack spacing={8}>
        {body.articles.length > 0 ? (
          body.articles.map((item) => <Feature key={item.url} article={item} />)
        ) : (
          <Text>No Results</Text>
        )}
      </Stack>
    </Stack>
  );
}

export default Results;
