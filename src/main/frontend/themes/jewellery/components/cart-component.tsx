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
    useStyles();
    useEffect(() => {
        const fetchCartItems = async () => {
            try {
                const cartItems = await CartItemService.listAll();
                // @ts-ignore
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

    const onRemoveItem = async (id: number) => {    }
    const onIncreaseQuantity = async (id: number) => {
        try {
            const cartItem = await CartItemService.increaseQuantity(id);
            // @ts-ignore
            setCartItems(prevState => {
                return prevState.map(item => {
                    if (item.id === id) {
                        return cartItem;
                    }
                    return item;
                });
            });
            setMessage('Quantity increased');
        } catch (err) {
            setError('Failed to increase quantity');
        }
    };

    const onDecreaseQuantity = async (id: number) => {
        try {
            const cartItem = await CartItemService.decreaseQuantity(id);
            // @ts-ignore
            setCartItems(prevState => {
                return prevState.map(item => {
                    if (item.id === id) {
                        return cartItem;
                    }
                    return item;
                });
            });
            setMessage('Quantity decreased');
        } catch (err) {
            setError('Failed to decrease quantity');
        }
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
                <div className="cart-item">
                    {cartItems.map(item => (
                        <div className="cart-item" key={item.id}>
                            <img src={item.product.imageUrl} alt={item.product.name} className="cart-item-image" />
                            <h3 className="cart-item-name">{item.product.name}</h3>
                            <p className="cart-item-price">${item.product.price.toFixed(2)}</p>
                            <div className="cart-item-quantity">
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
            );


    };




export default CartComponent;