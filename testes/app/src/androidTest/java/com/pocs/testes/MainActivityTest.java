package com.pocs.testes;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void deveExibirCPFInvalidoPoisCPFContemSomenteNumerosIguais() {
        String cpf = "1111111111";
        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.cpfEditText), isDisplayed()));
        appCompatEditText.perform(replaceText(cpf), closeSoftKeyboard());
        appCompatEditText.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.validarButton), isDisplayed()));

        appCompatButton.perform(click());

        appCompatEditText.check(matches(hasErrorText(mActivityTestRule.getActivity().getString(R.string.msgCPFInvalido))));
    }

    @Test
    public void deveExibirCPFInvalidoPoisCPFNaoContemOnzeDigitos() {
        String cpf = "123456789123";
        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.cpfEditText), isDisplayed()));
        appCompatEditText.perform(replaceText(cpf), closeSoftKeyboard());
        appCompatEditText.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.validarButton), isDisplayed()));

        appCompatButton.perform(click());

        appCompatEditText.check(matches(hasErrorText(mActivityTestRule.getActivity().getString(R.string.msgCPFInvalido))));
    }

    @Test
    public void deveExibirCPFInvalidoPoisCPFVazio() {
        String cpf = "";
        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.cpfEditText), isDisplayed()));
        appCompatEditText.perform(replaceText(cpf), closeSoftKeyboard());
        appCompatEditText.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.validarButton), isDisplayed()));

        appCompatButton.perform(click());

        appCompatEditText.check(matches(hasErrorText(mActivityTestRule.getActivity().getString(R.string.msgCPFInvalido))));
    }

    @Test
    public void deveExibirCPFInvalidoPoisCPFInvalido() {
        String cpf = "10040700632";
        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.cpfEditText), isDisplayed()));
        appCompatEditText.perform(replaceText(cpf), closeSoftKeyboard());
        appCompatEditText.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.validarButton), isDisplayed()));

        appCompatButton.perform(click());

        appCompatEditText.check(matches(hasErrorText(mActivityTestRule.getActivity().getString(R.string.msgCPFInvalido))));
    }

    @Test
    public void deveExibirCPFValidoPoisCPFValido() {
        String cpf = "10040700631";
        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.cpfEditText), isDisplayed()));
        appCompatEditText.perform(replaceText(cpf), closeSoftKeyboard());
        appCompatEditText.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.validarButton), isDisplayed()));

        appCompatButton.perform(click());

        onView(withText(mActivityTestRule.getActivity().getString(R.string.alertTitle))).check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
