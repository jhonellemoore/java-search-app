const { MongoClient } = require('mongodb');
require('dotenv').config({ path: '../.env' });
// or as an es module:
// import { MongoClient } from 'mongodb'

// Connection URL
// const url = 'mongodb://localhost:27017';
const url = process.env.MONGODB_URI;

if (!url) {
  console.error("MongoDB connection URL is not defined in the environment variables.");
  process.exit(1); // Exit the application or handle the error appropriately.
}

const client = new MongoClient(url);

// Database Name
const dbName = 'sample_mflix';

async function main() {
  // Use connect method to connect to the server
  await client.connect();
  console.log('Connected successfully to server');
  const db = client.db(dbName);

  const comments = db.collection('comments');
  const names = await db.listCollections().toArray();
  console.log(names)
  const options = {
    projection: { name: "Mercedes Taylor" }
  };
  const findResult = await comments.findOne({}, options);
  console.log(findResult)
  await client.close();
  // the following code examples can be pasted here...

  return 'done.';
}

main()
  .then(console.log)
  .catch(console.error)
  .finally(() => client.close());