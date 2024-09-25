import React, { useEffect, useState } from 'react';
import {
    Container,
    Typography,
    Button,
    makeStyles,
} from '@material-ui/core';
import Product from "Frontend/generated/com/eeshania/application/entities/Product";
import {CartItemService} from "Frontend/generated/endpoints";

interface CartItem {
    product: Product
    quantity: number
    id: number
}
const useStyles = makeStyles((theme) => ({
    productContainer: {
        padding: theme.spacing(4),
    },
    imageGrid: {
        marginTop: theme.spacing(2),
        marginBottom: theme.spacing(2),
    },
    productImage: {
        width: '100%',
        height: 'auto',
        borderRadius: theme.shape.borderRadius,
    },
    addToCartButton: {
        marginTop: theme.spacing(2),
    },
}));

const CartComponent = () => {
    const [cartItems, setCartItems] = useState<CartItem[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);
    const [message, setMessage] = useState<string | null>(null);
    const classes = useStyles();
    useStyles();
    useEffect(() => {
        const fetchCartItems = async () => {
            try {
                const cartItems: any[] = await CartItemService.listAll();

                setCartItems(prevState => {
                    return [...prevState, ...cartItems];
                });
                setLoading(false);
            } catch (err) {
                setError('Failed to fetch cart items');
                setLoading(false);
            }
        };
            fetchCartItems();
            }, []);

    const onRemoveItem = async (id: number) => {
        try {
             await CartItemService.removeItem(id)
            const newList = cartItems.filter(item => item.id !== id);

            setCartItems(newList);

        } catch (err) {
            setCartItems(prevState => {
                return prevState.filter(item => item.id !== id);
            })

        }




        setMessage('Quantity increased');
    }
    const onIncreaseQuantity = async (id: number) => {

           try {
               await CartItemService.increaseQuantity(id);
           } catch (err) {
               setCartItems(prevState => {
                   return prevState.map(item => {
                       if (item.id === id) {
                           return { ...item, quantity: item.quantity + 1 };
                       }
                       return item;
                   });
               });
           }

            setMessage('Quantity increased');

    };

    const onDecreaseQuantity = async (id: number) => {
        try {
            await CartItemService.decreaseQuantity(id);
        } catch (err) {
            setCartItems(prevState => {
                return prevState.map(item => {
                    if (item.id === id) {
                        return { ...item, quantity: item.quantity - 1 };
                    }
                    return item;
                });
            });
        }

        setMessage('Quantity increased');

    };

        if (loading) {
            return <Typography>Loading...</Typography>;
        }

        if (error) {
            return <Typography color="error">{error}</Typography>;
        }

        if (!cartItems) {
            return <Typography>No product found.</Typography>;
        }

        return (

            <Container className={classes. productContainer}>
                <div style={styles.container}>
                    <h1>Shopping Cart</h1>
                    {message && <p>{message}</p>}
                    <button onClick={() => setMessage(null)}>Clear</button>
                    <div style={styles.grid}>
                     <div className="cart-item">
                    {cartItems.map(item => (
                        <div className="cart-item" key={item.id}  style={styles.card}>
                            <img src={item.product.imageUrl} alt={item.product.name} className="cart-item-image" style={styles.image} />
                            <h3 className="cart-item-name">{item.product.name}</h3>
                            <p className="cart-item-price">${item.product.price.toFixed(2)}</p>
                            <div className="cart-item-quantity" >
                                <button onClick={() => onDecreaseQuantity(item.id)}>-</button>
                                <span>{item.quantity}</span>
                                <button onClick={() => onIncreaseQuantity(item.id)}>+</button>
                            </div>
                            <button onClick={() => onRemoveItem(item.id)} className="cart-item-remove">
                                Remove
                            </button>



                    </div>
                    ))
                    }
                    </div>
                    </div>
                </div>


            </Container>
            );


    };


const styles = {
    container: {
        padding: '20px',
        textAlign: 'left' as 'left',
    },
    grid: {
        display: 'grid',
        gridTemplateColumns: 'repeat(auto-fill, minmax(200px, 1fr))',
        gap: '16px',
    },
    card: {
        border: '1px solid #ccc',
        borderRadius: '8px',
        padding: '16px',
        textAlign: 'center' as 'center',
    },
    image: {
        width: '100%',
        height: 'auto',
    },
    name: {
        fontSize: '18px',
        margin: '10px 0',
    },
    price: {
        fontSize: '16px',
        margin: '10px 0',
    },
    button: {
        backgroundColor: '#007BFF',
        color: '#fff',
        border: 'none',
        borderRadius: '4px',
        padding: '10px 15px',
        cursor: 'pointer',
    },
};

export default CartComponent;