import { Box, Spacer, Flex, Link } from "@chakra-ui/react";


function PageHeader() {
    return(
      <Flex direction="row">
          <Spacer />
          <Box o="2"><Link href="/" mr="4">Twitter search</Link></Box>
          <Spacer />
          <Link href="/about" mr="4">
            About
          </Link>
        </Flex>
    );
  }


export default PageHeader;