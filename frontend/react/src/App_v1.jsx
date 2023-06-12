// import UserProfile from "./UserProfile.jsx";
// import {useState, useEffect} from 'react';
//
// const users = [
//     {
//         name: "Jamila",
//         age: 22,
//         gender: "FEMALE"
//     },
//     {
//         name: "Ana",
//         age: 45,
//         gender: "FEMALE"
//     },
//     {
//         name: "Alex",
//         age: 18,
//         gender: "MALE"
//     },
//     {
//         name: "Bob",
//         age: 27,
//         gender: "MALE"
//     }
// ]
//
// const UserProfiles = () => (
//     <div>
//         {users.map((user, index) => {
//             return <UserProfile
//                 key={index} //when we are using map, we have to assign a key
//                 name={user.name}
//                 age={user.age}
//                 gender={user.gender}
//                 imageNumber={index}
//             />
//         })}
//     </div>
// )
//
// function App() {
//
//     const [counter, setCounter] = useState(0);
//     const [isLoading, setIsLoading] = useState(true);
//
//     useEffect(() => {
//         setIsLoading(true);
//         setTimeout(() => {
//             setIsLoading(false);
//         }, 4000);
//     }, [])
//
//     if (isLoading) {
//         return "Loading..."
//     }
//
//     return (
//         <div>
//             <button onClick={() => setCounter(prevCounter => prevCounter + 1)}>
//                 Increment counter
//             </button>
//             <h1>{counter}</h1>
//             <UserProfiles/>
//         </div>
//     );
// }
//
// export default App
